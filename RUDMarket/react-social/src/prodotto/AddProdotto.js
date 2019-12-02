import React, { Component } from 'react';
import { addProdotto } from '../util/APIUtils';
import Alert from 'react-s-alert';

class AddProdotto extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nome: '',
            marca: ''
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleChangeSteps = this.handleChangeSteps.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeTitle(event) {
        this.setState({nome: event.target.value});
    }
    
    handleChangeSteps(event) {
        this.setState({marca: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const addProdottoRequest = Object.assign({}, this.state);
        addProdotto(addProdottoRequest)
            .then(response => {
                Alert.success("Prodotto aggiunto correttamente!");

            }).catch(error => {
                Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
            });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                Nome Prodotto:
                <input
                    type="text"
                    ref="nomeForm"
                    value={this.state.nome}
                    onChange={this.handleChangeTitle}/>
                </label>
                <label>
                Marca Prodotto:
                <input
                    type="text"
                    ref="marcaForm"
                    value={this.state.marca}
                    onChange={this.handleChangeSteps}/>
                </label>
                <input type="submit" value="Aggiungi"/>
            </form>
        );
    }
}

export default AddProdotto