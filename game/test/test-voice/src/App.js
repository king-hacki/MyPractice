import React from 'react';
import './App.css';
import { SayButton } from 'react-say'
import { Image } from 'semantic-ui-react'


function App() {
  return (
    <div>
      <SayButton onClick={ event => console.log(event) } speak="cat">
        Tell me a story
      </SayButton>
      <Image src='../public/logo192.png' size='huge' wrapped/>
    </div>
  );
}

export default App;
