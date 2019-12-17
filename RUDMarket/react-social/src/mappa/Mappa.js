import React, { Component } from 'react'
import { GoogleMap, LoadScript, Marker } from '@react-google-maps/api'
import { GOOGLE_MAPS_API_KEY } from '../constants';

class Mappa extends Component {
    constructor(props) {
        super(props);
        console.log(props);
    }

    render() {

        const onLoad = marker => {
            console.log('marker: ', marker)
        };

        const markerPosition = {
            lat: 45.0704179,
            lng: 7.6241255
        };

        return (
            <body>
            <section class="jumbotron text-center">
            <h2>I nostri supermercati</h2>
                <div className="container">
                    <LoadScript //TODO there's a better way to do this
                        id="script-loader"
                        googleMapsApiKey = {GOOGLE_MAPS_API_KEY}
                        //language={"italian"}
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
                        <Marker //TODO still not working as expected
                            onLoad={onLoad}
                            position={markerPosition}
                        />
                        </GoogleMap>
                    </LoadScript>
                </div>
            </section>
            </body>
        )
    }
}

export default Mappa;