import React from 'react'
import './Sconto.css'

const ScontiAttivi = ({ scontiAttivi }) => {
    return(
        <tbody>
            {scontiAttivi.map((scontoAttivo) => (
                <tr>
                    <th>{scontoAttivo.prodotto.nome}</th>
                    <th>{scontoAttivo.prodotto.marca}</th>
                    <th>{scontoAttivo.perc}</th>
                </tr>
            ))}
        </tbody>
    );
};

export default ScontiAttivi