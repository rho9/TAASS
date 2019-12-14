import React from 'react'
import './Carrello.css'

const ProdottiInCarrello = ({ prodottiInCarrello }) => {
    return(
        <tr>
            {prodottiInCarrello.map((prodotto) => (
                <th>{prodotto.nome}</th>
            ))}
        </tr>
    );
};

export default ProdottiInCarrello