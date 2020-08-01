import React, {Component} from 'react';
import {Card, Icon, Image} from 'semantic-ui-react';
import './product.scss';

export default class Product extends Component {

    constructor(props) {
    		super(props);
    		this.state = {
    			status: false,
    			id: this.props.id
    		};
    		this.handleChange = this.handleChange.bind(this);
    		this.updateProductsCounter = this.updateProductsCounter.bind(this);
    }

    updateProductsCounter() {
    		console.log(this.state);
    		//this.props.handleCounter(this.state);
    }

    handleChange() {
    		this.setState({status: !this.state.status}, this.updateProductsCounter);
    }

    render() {
    		return (
    			<Card>
    				<Image
    					src={this.props.cover}
    					alt="Product cover"
    					style={{width: 330 + 'px', height: 425 + 'px'}}
    				/>
    				<Card.Content>
    					<Card.Header>{this.props.name}</Card.Header>
    					<Card.Meta>
    						<span className="date" />
    					</Card.Meta>
    				</Card.Content>
    				<Card.Content extra>
    					<div className="ui checkbox">
    						<input
    							type="checkbox"
    							name="example"
    							onChange={this.handleChange}
    						/>
    						<label>Do you like this product?</label>
    					</div>
    				</Card.Content>
    			</Card>
    		);
    	}

}