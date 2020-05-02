import React from 'react';
import { Stage, Layer, Rect } from 'react-konva'

class Say extends React.Component {

    onSay = () => {
        speechSynthesis.speak(new SpeechSynthesisUtterance("i was clicked"))
      }

    render() {
        return (
            <Stage 
                width={800}
                height={400}>
                <Layer>
                    <Rect
                        width={300}
                        height={300}
                        fill='black'
                        onClick={this.onSay}
                    />
                </Layer>
            </Stage>
        )
    }
}

export default Say

