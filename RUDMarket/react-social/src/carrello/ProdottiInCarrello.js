import React from 'react'
import './Carrello.css'

const ProdottiInCarrello = ({ prodottiInCarrello }) => {
    return(
        <tbody>
            {prodottiInCarrello.map((prodottoInCarrello) => (
                <tr>
                    <th>{prodottoInCarrello.quantita}</th>
                    <th>{prodottoInCarrello.prodotto.nome}</th>
                    <th>{prodottoInCarrello.prodotto.marca}</th>
                    {
                        prodottoInCarrello.percSconto == 0 ? (
                            <th>{prodottoInCarrello.prodotto.prezzo}</th>
                        ) : (
                            <th>{prodottoInCarrello.prodotto.prezzo} - ({prodottoInCarrello.percSconto}%)</th>
                        )
                    }
                    <th>{(prodottoInCarrello.prodotto.prezzo - ((prodottoInCarrello.prodotto.prezzo * prodottoInCarrello.percSconto) / 100)) * prodottoInCarrello.quantita}</th>
                </tr>
            ))}
        </tbody>
    );
};

export default ProdottiInCarrello