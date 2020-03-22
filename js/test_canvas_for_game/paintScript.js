const canvas = document.getElementById('canvas')
const context = canvas.getContext('2d');
let isMouseDown = false
let coords = []

canvas.width = window.innerWidth
canvas.height = window.innerHeight

//  Start 

context.lineWidth=5 * 2;

canvas.addEventListener('mousedown', () => {
    isMouseDown = true
})

canvas.addEventListener('mouseup', () => {
    isMouseDown = false
    context.beginPath();
    coords.push('mouseup')
})

canvas.addEventListener('mousemove', e => {

    if (isMouseDown) {

        coords.push([e.clientX, e.clientY])

        context.lineTo(e.clientX, e.clientY);
        context.stroke();

        context.beginPath();
        context.arc(e.clientX, e.clientY, 5, 0, Math.PI * 2);
        context.fill();

        context.beginPath();
        context.moveTo(e.clientX, e.clientY);

    }
    
})

const replay = () => {
    
    let timer = setInterval(() => {
        
        if (!coords.length) {
            clearInterval(timer)
            context.beginPath();
            return
        }

        let crd = coords.shift(),
        e = {
            clientX: crd['0'],
            clientY: crd['1']
        }


        context.lineTo(e.clientX, e.clientY);
        context.stroke();

        context.beginPath();
        context.arc(e.clientX, e.clientY, 5, 0, Math.PI * 2);
        context.fill();

        context.beginPath();
        context.moveTo(e.clientX, e.clientY);


    }, 10)
}

const save = () => {
    localStorage.setItem('coords', JSON.stringify(coords))
}

const clear = () => {
    context.fillStyle='white';
    context.fillRect(0, 0, canvas.width, canvas.height)

    context.beginPath();
    context.fillStyle='black'
}

document.addEventListener('keypress', e => {
    switch(e.keyCode) {
        case 115:
            //  save
            save()
            console.log("save")
            break
        case 114:
            //  replay
            console.log("replaing")

            coords = JSON.parse(localStorage.getItem('coords'))

            clear()
            replay()

            break
        case 99:
            //  clear   c
            clear();
            console.log("cleare")
            break
        default: 
            break
    }
})