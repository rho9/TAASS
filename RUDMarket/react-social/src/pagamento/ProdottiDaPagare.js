import React from 'react'
import './Pagamento.css'

const ProdottiDaPagare = ({ prodottiDaPagare }) => {
    return(
        <tbody>
        {prodottiDaPagare.map((prodotto) => (
            <li className="list-group-item d-flex justify-content-between lh-condensed">
            <div>
            <h6 className="my-0">{prodotto.nome}</h6>
            <small className="text-muted">{prodotto.marca}</small>
            </div>
            <span className="text-muted">{prodotto.prezzo}€</span>
            </li>
        ))}
        </tbody>
    );
};

export default ProdottiDaPagare