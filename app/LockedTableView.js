import React, {
    Component,
} from 'react';
import {
    Dimensions,
    requireNativeComponent,
} from 'react-native';

const FixTableView = requireNativeComponent('RCTFixedTableView', LockedTableView);

export default class LockedTableView extends React.Component {

    render() {
        return (
            <FixTableView
                style={{
                    flex: 1,
                    width: Dimensions.get('window').width,
                    height: Dimensions.get('window').height,
                }} />
        );
    }
}