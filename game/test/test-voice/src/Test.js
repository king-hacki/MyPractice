import React, { Component } from 'react'
import { SayButton } from 'react-say'
import  Say  from 'react-say'
import { Stage, Layer, Rect } from 'react-konva'
import { useSynthesize } from 'react-say';



class Test extends Component {
    
    render() {
       
                // {/* <Stage width={700} height={500}>
                //     <Layer>
                //         <Rect
                //             width={300}
                //             height={300}
                //             fill="red"
                //             onClick={this.onClick}
                //         />
                //     </Layer>
                // </Stage> */}

        const synthesize = useSynthesize();
 
        // When this component is mounted, the utterance will be queued immediately.
        useEffect(() => {
            const { cancel } = synthesize('A quick brown fox jumped over the lazy dogs.');
        
            // When this component is unmounted, the synthesis will be cancelled.
            return () => cancel();
        }, [synthesize]);
        
        return (
            <button onClick={ this.useEffect }>Tell me a story</button>
        );
    }
}

export default Test
