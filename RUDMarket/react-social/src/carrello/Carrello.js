import React, { Component } from 'react';
import './Carrello.css'

import ProdottiInCarrello from "./ProdottiInCarrello";

class Carrello extends Component {
    constructor(props) {
        super(props);
        this.state = {
            prodottiInCarrello: []
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/carrello/getProdottiInCarrello')
            .then(res => res.json())
            .then((data) => {
                alert(data)
                this.setState({ prodottiInCarrello: data })
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