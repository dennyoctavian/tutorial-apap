import React from "react";
import { Route, Switch, Redirect } from 'react-router-dom';
import ItemList from "./containers/itemlist";
import CartList from "./containers/cartlist";

export const AppRoutes = () => {
    return(
        <div>
            <Switch>
                <Route exact path="/" component={ItemList} />
                <Route exact path="/cart" component={CartList} />
                <Route exact path="/">
                    <Redirect to="/" />
                </Route>
            </Switch>
        </div>
    )
}