import './App.css';
import "./views/Home/index";
import Home from './views/Home/index';
import { ThemeProvider } from 'styled-components';
import { lightTheme, darkTheme } from './theme';
import { GlobalStyles } from './global';
import React, { useState } from 'react';



function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    // if the theme is not light, then set it to dark
    if (theme === 'light') {
      setTheme('dark');
    // otherwise, it should be light
    } else {
      setTheme('light');
    }
  }
  return (
    
    <div className="App">
      <ThemeProvider theme={lightTheme}>
      <GlobalStyles />
        <button className="btn btn-primary" onClick={toggleTheme}>Toggle theme</button>
        <Home />
      </ThemeProvider>
      
    </div>
  );
}

export default App;
