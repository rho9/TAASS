import React, { Component } from 'react';
import './Carrello.css'

class Carrello extends Component {
    render() {
        return (
            <body>
            <section class="jumbotron text-center">
            <h2>Il tuo RUDCarrello</h2>
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Quantità</th>
                        <th>Prodotto</th>
                        <th>Marca</th>
                        <th>Prezzo unitario</th>
                        <th>Prezzo totale</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                    </tr>
                    <tr>
                        <td>1,002</td>
                        <td>amet</td>
                        <td>consectetur</td>
                        <td>adipiscing</td>
                        <td>elit</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            </section>
            </body>
        );
    }
}

export default Carrello;