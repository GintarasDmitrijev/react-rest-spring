'use strict';

const React = require('react');
const ReactDOM = require('react-dom');

const regeneratorRuntime = require("regenerator-runtime");

import Select from 'react-select';

import './app.scss';
import './components/product.scss';

import Product from './components/Product.jsx';

///////////////////////////////////////////////////////////////////////////////
class App extends React.Component {

    constructor() {
          super();
          this.state = { data: [] };
          this.formSubmit = this.formSubmit.bind(this);
        }

    async formSubmit(event) {
          event.preventDefault();
          //console.log(this.state.selectedOption);

          let questionnaire = {
                      age:     event.target.age.value,
                      student: event.target.student.value,
                      income:  event.target.income.value
                  }

          const response = await fetch('/post', {
                    method: 'POST',
                    headers: {
                      'Accept': 'application/json',
                      'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(questionnaire)
                    });

          const json = await response.json();
          this.setState({ data: json });
          console.log('This is your data', json);

          ReactDOM.render(
          	<ProductOffer
          	state={this.state}/>,
          	document.getElementById('react')
          )
        }

    render() {
      return (
            <form className='form-style' onSubmit={this.formSubmit}>
             <h1>Fill-in the form</h1>
             <ul>
                <AgeRadioGroup/>
                <StudentOrNot/>
                <SelectIncome/>
                <button className="submit-button" type="submit">
                    Get offer
                </button>
              </ul>
            </form>
      );
    }
}

class AgeRadioGroup extends React.Component {

  constructor() {
      super();
      this.state = {
        name: "React"
      };
      this.onValueChange = this.onValueChange.bind(this);
      //this.formSubmit = this.formSubmit.bind(this);
    }

    onValueChange(event) {
      this.setState({
        selectedOption: event.target.value
      });
    }

    render() {
      return (
        <li className='list-item'>
         <label htmlFor="age-group" className="label">Your age</label>
         <div id="row" name="age-group">
          <div id="left">
            <label>
              <input
                type="radio"
                name="age"
                value="0-17"
                checked={this.state.selectedOption === "0-17"}
                onChange={this.onValueChange}
              />
              0-17
            </label>
          </div>
          <div id="center">
            <label>
              <input
                type="radio"
                name="age"
                value="18-64"
                checked={this.state.selectedOption === "18-64"}
                onChange={this.onValueChange}
              />
              18-64
            </label>
          </div>
          <div id="right">
            <label>
              <input
                type="radio"
                name="age"
                value="65+"
                checked={this.state.selectedOption === "65+"}
                onChange={this.onValueChange}
              />
              65+
            </label>
          </div>
          </div>
          <span className='span'>Specify you age here</span>
          {/* <div>
             Selected option is : {this.state.selectedOption}
           </div> */ }
        </li>
      );
    }
  }

class StudentOrNot extends React.Component {

  constructor() {
      super();
      this.state = {
        name: "React"
      };
      this.onValueChange = this.onValueChange.bind(this);
      //this.formSubmit = this.formSubmit.bind(this);
    }

    onValueChange(event) {
      this.setState({
        selectedOption: event.target.value
      });
    }

    render() {
      return (
         <li className='list-item'>
         <label htmlFor='student-group' className='label'>Are you a student?</label>
         <div id="row" name="student-group">
          <div id="left">
            <label>
              <input
                type="radio"
                name="student"
                value="Yes"
                checked={this.state.selectedOption === "Yes"}
                onChange={this.onValueChange}
              />
              Yes
            </label>
          </div>
          <div id="right">
            <label>
              <input
                type="radio"
                name="student"
                value="No"
                checked={this.state.selectedOption === "No"}
                onChange={this.onValueChange}
              />
              No
            </label>
          </div>
          </div>
          <span className='span'>Specify whether you are a student</span>
          {/* <div>
               Selected option is : {this.state.selectedOption}
          </div> */ }
           </li>
      );
    }
  }

const options = [
  { value: '0', label: '0' },
  { value: '1-12000', label: '1-12000' },
  { value: '12001-40000', label: '12001-40000' },
  { value: '40001+', label: '40001+' }
];

class SelectIncome extends React.Component {
  state = {
      selectedOption: null,
    };
    handleChange = selectedOption => {
      this.setState({ selectedOption });
      console.log(`Option selected:`, selectedOption);
    };
    render() {
      const { selectedOption } = this.state;

      return (
      <li className='list-item'>
       <label htmlFor='income-select' className='label'>Your annual income</label>
         <div name="income-select">
          <Select
            value={selectedOption}
            name='income'
            onChange={this.handleChange}
            options={options}
          />
         </div>
         <span className='span'>Specify your annual income</span>
        </li>
      );
    }
}

class ProductOffer extends React.Component{

	render() {
	    const products = this.props.state.data.map((_product, _id) =>
	                <Product
                         name={_product.name}
                         cover={_product.image}
                    />

                   // <li>{_product.name}</li>
                    );
		return (
		  <>
		    <h1>We could offer you the following product(s):</h1><br/>
			<div className="products">
                {products}
            </div>
     	  </>
		)

	}

}

///////////////////////////////////////////////////////////////////////////////
ReactDOM.render(
	<App/>,
	document.getElementById('react')
)
