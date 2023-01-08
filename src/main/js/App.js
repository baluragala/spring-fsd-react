import React, { Component } from "react";
import "./App.css";
import List from "./components/List";
import AddChocolate from "./components/AddChocolate";
import { maxBy } from "lodash";
import client from "./client";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      chocolates: [

      ]
    };
    this.handleChocolateAdd = this.handleChocolateAdd.bind(this);
    this.handleChocolateSale = this.handleChocolateSale.bind(this);
  }

  handleChocolateAdd(chocolate) {
    // let newId = maxBy(this.state.chocolates, "id");
    // let chocolates = this.state.chocolates.slice();
    // chocolate["id"] = newId;
    // chocolates.push(chocolate);
    // this.setState({ chocolates });
  }

  handleChocolateSale(name) {
    var chocolates = [];
    this.state.chocolates.forEach((ele, index, arr) => {
      if (ele.name === name) {
        ele.soh -= 1;
      }
      chocolates.push(ele);
    });
    this.setState({ chocolates });
  }

  componentDidMount() { // <2>
    client({method: 'GET', path: '/api/chocolates'}).done(response => {
      this.setState({chocolates: response.entity._embedded.chocolates});
    });
  }

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src="./choclate_logo.jpg" className="App-logo" alt="logo" />
          <h2>Welcome to React - Chocolate Store</h2>
        </div>
        <AddChocolate onChocolateAdd={this.handleChocolateAdd} />
        <List
          chocolates={this.state.chocolates}
          onChocolateSale={this.handleChocolateSale}
        />
      </div>
    );
  }
}

export default App;
