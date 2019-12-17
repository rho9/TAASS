import React, { Component } from 'react';
import './Sconto.css'

import {getScontiAttivi} from "../util/APIUtils";
import ScontiAttivi from "./ScontiAttivi";

class Sconto extends Component {
    constructor(props) {
        super(props);
        this.state = {
            scontiAttivi: [],
        }

        getScontiAttivi()
            .then(response => {
                this.setState({
                    scontiAttivi: response
                });
            })
    }

    render() {
        return (
            <body>
            <section class="jumbotron text-center">
                <h2>I tuoi sconti attivi</h2>
                <div className="table-responsive">
                    <table className="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>Prodotto</th>
                            <th>Marca</th>
                            <th>Percentuale di Sconto</th>
                        </tr>
                        </thead>
                        <ScontiAttivi scontiAttivi={this.state.scontiAttivi} />
                    </table>
                </div>
            </section>
            </body>
        );
    }
}

export default Sconto;