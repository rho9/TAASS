import React from 'react'

class SezioniCombo extends React.Component {
    constructor() {
        super();
    }

    render () {
        let sezioni = this.props.state.sezioni;
        let optionItems = sezioni.map((sezione) =>
            <option key={sezione.id}>{sezione.name}</option>
        );

        return (
            <div>
                <select>
                    {optionItems}
                </select>
            </div>
        )
    }
}

export default SezioniCombo;