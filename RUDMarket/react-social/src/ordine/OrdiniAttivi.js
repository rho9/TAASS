import React from 'react'
import './Ordine.css'

const OrdiniAttivi = ({ ordiniAttivi }) => {
    return(
        <tbody>
            {ordiniAttivi.map((ordineAttivo) => (
                <tr>
                    <th>{ordineAttivo.quantita}</th>
                    <th>{ordineAttivo.prodotto.nome}</th>
                    <th>{ordineAttivo.prodotto.marca}</th>
                    {
                        ordineAttivo.indirizzo != null ? (
                            <th>{ordineAttivo.indirizzo}</th>
                        ) : (
                            <th>{ordineAttivo.supermercatoNome}</th>
                        )
                    }
                </tr>
            ))}
        </tbody>
    );
};

export default OrdiniAttivi