import React, { Component } from 'react'
import { GoogleMap, LoadScript, Marker } from '@react-google-maps/api'
import { GOOGLE_MAPS_API_KEY } from '../constants';
import {getSupermercati} from "../util/APIUtils";

class Mappa extends Component {
    constructor(props) {
        super(props);
        this.state = {
            markers: []
        }
        console.log(props);

        getSupermercati()
            .then(data => {
                let supFromApi = data.map(sup => { return {lat: sup.lat, lng: sup.lng} })
                this.setState({ markers: [].concat(supFromApi) })
            })
    }

    render() {

        const onLoad = marker => {
            console.log('marker: ', marker)
        };

        return (
            <body>
            <section class="jumbotron text-center">
            <h2>I nostri supermercati</h2>
                <div className="container">
                    <LoadScript //TODO there's a better way to do this
                        id="script-loader"
                        googleMapsApiKey = {GOOGLE_MAPS_API_KEY}
                    >
                        <GoogleMap
                            id='rud-map'
                            mapContainerStyle={{
                                height: "400px",
                                width: "640px",
                            }}
                            zoom={13}
                            center={{
                                lat: 45.0644956,
                                lng: 7.6741106
                            }}
                        >

                            {
                                this.state.markers.map((marker) => (
                                        <Marker
                                            onLoad={onLoad}
                                            position={marker}
                                        />
                                    )
                                )
                            }
                        </GoogleMap>
                    </LoadScript>
                </div>
            </section>
            </body>
        )
    }
}

export default Mappa;