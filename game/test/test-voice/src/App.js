import React from 'react';
import './App.css';
import { SayButton } from 'react-say'
import { Image, Grid, Header } from 'semantic-ui-react'


function App() {
  return (
    <div>
      <SayButton onClick={ event => console.log(event) } speak="cat">
        Tell me a story
      </SayButton>
      <Image src='../public/logo192.png' size='huge' wrapped/>

       <Grid  columns={2}>
        <Grid.Row>
            <Grid.Column>
                <Header>Text</Header>
            </Grid.Column>
            <Grid.Column>
                <Header>Text</Header>
            </Grid.Column>
        </Grid.Row>
    </Grid>

    </div>
  );
}

export default App;
