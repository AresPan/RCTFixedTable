/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
} from 'react-native';

import FixTableView from  './app/LockedTableView';

export default class RCTFixedTable extends Component {
  render() {
    return (
      <FixTableView />
    );
  }
}

AppRegistry.registerComponent('RCTFixedTable', () => RCTFixedTable);
