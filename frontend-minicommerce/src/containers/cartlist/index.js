import React, { Component } from "react";
import ItemCart from "../../components/ItemCart";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import { Link } from "react-router-dom";
import { Fab } from "@mui/material";

class CartList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            keyword: "",
            cartItems: [],
            cartHidden: true,
        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleCheckout = this.handleCheckout.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }


    async loadData() {
        try {
            const { data } = await APIConfig.get("/cart");
            console.log(data.result);
            this.setState({ items: data.result });
            } 
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ 
            isLoading: !currentLoading
        });
        console.log(this.state.isLoading);
    }

    async handleCheckout(event) {
        event.preventDefault();
        try {
            await APIConfig.get("/cart/checkout");
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0,
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render() {
        console.log("render()");
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>Cart Items</h1>
                <div>
                    <Link to="/">  
                        <Button>
                            Back
                        </Button>
                    </Link>

                    
                    <Button action={this.handleCheckout}>
                        Checkout
                    </Button>
                
                    
                </div>
                
                <div>
                    {this.state.items.map((item) => (
                        <ItemCart
                            key={item.id}
                            id={item.id}
                            title={item.item.title}
                            price={item.item.price}
                            description={item.item.description}
                            category={item.item.category}
                            quantity={item.quantity}
                            totalHarga={item.item.price*item.item.quantity}
                        />
                    ))}
                </div>
            </div>
        );
    }
}
export default CartList;