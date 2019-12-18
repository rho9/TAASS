import React, { Component } from 'react';
import './Ordine.css'

import {getOrdiniAttivi, getScontiAttivi} from "../util/APIUtils";
import OrdiniAttivi from "./OrdiniAttivi";

class Ordine extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ordiniAttivi: [],
        }

        getOrdiniAttivi()
            .then(response => {
                this.setState({
                    ordiniAttivi: response
                });
            })
    }

    render() {
        return (
            <body>
            <section class="jumbotron text-center">
                <h2>I tuoi ordini attivi</h2>
                <div className="table-responsive">
                    <table className="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>Prodotto</th>
                            <th>Marca</th>
                            <th>Luogo di Consegna</th>
                        </tr>
                        </thead>
                        <OrdiniAttivi ordiniAttivi={this.state.ordiniAttivi} />
                    </table>
                </div>
            </section>
            </body>
        );
    }
}

export default Ordine;