import React from 'react'

const Sezioni = ({ sezioni }) => {
    return (
        <div>
            <h1>Sezioni presenti</h1>
            {sezioni.map((sezione) => (
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">{sezione.nome}</h5>
                    </div>
                </div>
            ))}
        </div>
    )
};

export default Sezioni