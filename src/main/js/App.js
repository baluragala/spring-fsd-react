'use strict';

import React from "react";
import ReactDOM from "react-dom";
import client from "./client";
import EmployeeList from "./components/EmployeeList";

// tag::app[]
export default class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {employees: []};
	}

	componentDidMount() { // <2>
		client({method: 'GET', path: '/api/employees'}).done(response => {
			this.setState({employees: response.entity._embedded.employees});
		});
	}

	render() { // <3>
		return (
			<EmployeeList employees={this.state.employees}/>
		)
	}
}
// end::app[]





// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]
