import React, { Component } from 'react';
import './Sezione.css';
import {Link} from "react-router-dom";
import ProdottoList from "./ProdottoList";

class Sezione extends Component {
    constructor(props) {
        super(props);
        this.state = {
            prodotti: []
        }

        this.componentDidMount.bind(this)
    }

    componentDidMount() {
        fetch('http://localhost:8080/sezione/getProdottiByIdSezione', {
            method: 'POST',
            body: "id=" + this.props.location.idSezione
        })
            .then(res => res.json())
            .then((data) => {
                this.setState({ prodotti: data })
            })
    }

    render() {
        return(
            <body>
                <div className="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
                    <h1 className="display-4">{this.props.location.nomeSezione}</h1>
                </div>

                <div className="container">
                    <div className="card-deck mb-3 text-center">
                        <ProdottoList prodotti={this.state.prodotti} />
                    </div>
                </div>
            </body>
        );
    }
}

export default Sezione;