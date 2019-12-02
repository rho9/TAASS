import React, { Component } from 'react';
import { addSezione } from '../util/APIUtils';
import Alert from 'react-s-alert';

class AddSezione extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nome: ''
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeTitle(event) {
        this.setState({nome: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const addSezioneRequest = Object.assign({}, this.state);
        addSezione(addSezioneRequest)
            .then(response => {
                Alert.success("Sezione aggiunta correttamente!");

            }).catch(error => {
                Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
            });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                Nome Sezione:
                <input
                    type="text"
                    value={this.state.nome}
                    onChange={this.handleChangeTitle}/>
                </label>
                <input type="submit" value="Aggiungi"/>
            </form>
        );
    }
}

export default AddSezione