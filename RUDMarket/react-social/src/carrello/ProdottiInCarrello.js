import React from 'react'
import './Carrello.css'

const ProdottiInCarrello = ({ prodottiInCarrello }) => {
    return(
        <tbody>
            {prodottiInCarrello.map((prodotto) => (
                <tr>
                    <th>1</th>
                    <th>{prodotto.nome}</th>
                    <th>{prodotto.marca}</th>
                    <th>{prodotto.prezzo}</th>
                    <th>{prodotto.prezzo}</th>
                </tr>
            ))}
        </tbody>
    );
};

export default ProdottiInCarrello