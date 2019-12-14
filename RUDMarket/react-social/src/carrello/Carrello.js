import React, { Component } from 'react';
import './Carrello.css'

import ProdottiInCarrello from "./ProdottiInCarrello";
import {getProdottiInCarrello} from "../util/APIUtils";

class Carrello extends Component {
    constructor(props) {
        super(props);
        this.state = {
            prodottiInCarrello: []
        }

        getProdottiInCarrello()
            .then(response => {
                this.setState({
                    prodottiInCarrello: response
                });
            })
    }

    render() {
        return (
            <body>
            <section class="jumbotron text-center">
            <h2>Il tuo RUDCarrello</h2>
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Prodotto</th>
                    </tr>
                    </thead>
                    <tbody>
                    <ProdottiInCarrello prodottiInCarrello={this.state.prodottiInCarrello} />
                    </tbody>
                </table>
            </div>
            </section>
            </body>
        );
    }
}

export default Carrello;