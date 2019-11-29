import React, { Component } from 'react';
import { addRecipe } from '../util/APIUtils';
import Alert from 'react-s-alert';
/*import './Profile.css';*/

class AddRecipe extends Component {
    constructor(props) {
        super(props);
        this.state = {
            title: '',
            steps: ''
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleChangeSteps = this.handleChangeSteps.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeTitle(event) {
        this.setState({title: event.target.value});
    }
    
    handleChangeSteps(event) {
        this.setState({steps: event.target.value});
    }

    handleSubmit(event) {
        alert("È stato inserito una ricetta: " + this.state.title + this.state.steps);
        
        event.preventDefault();

        const addRecipeRequest = Object.assign({}, this.state);
        addRecipe(addRecipeRequest)
            .then(response => {
                Alert.success("Ricetta aggiunta correttamente!");
                //this.props.history.push("/profile");
            }).catch(error => {
                Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
            });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                Nome ricetta:  
                <input
                    type="text"
                    value={this.state.title}
                    onChange={this.handleChangeTitle}/>
                </label>
                <label>
                Steps: 
                <input
                    type="text"
                    value={this.state.steps}
                    onChange={this.handleChangeSteps}/>
                </label>
                <input type="submit" value="Submit" />
            </form>
        );
    }
}

export default AddRecipe