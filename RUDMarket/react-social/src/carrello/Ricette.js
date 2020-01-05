import React from 'react'
import './Carrello.css'

const Ricette = ({ ricette, chiavi }) => {
    return(
        <body>
            {
                chiavi.map((chiave) => (
                    ricette[chiave].length > 0 ? (
                            <section className="jumbotron text-center">
                                <h2>Ricette con {chiave}</h2>
                                <div className="table-responsive">
                                    <table className="table table-striped table-sm">
                                        <tbody>
                                        {
                                            ricette[chiave].map((ricetta) => (
                                                <tr>
                                                    <th>{ricetta.title}</th>
                                                </tr>
                                            ))
                                        }
                                        </tbody>
                                    </table>
                                </div>
                            </section>
                        ) : (
                            <section></section>
                    )
                ))
            }
        </body>
    );
};

export default Ricette