function calcular() {
    const operando1 = document.getElementById('operando1').value;
    const operador = document.getElementById('operador').value;
    const operando2 = document.getElementById('operando2').value;

    //enviar informações para back
    fetch('/calcular', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ operando1, operador, operando2 }),
    })
    
    //recuperando mensagens assim que o servidor responde
    .then(response => response.json())
    .then(data => {
        document.getElementById('resultado').innerText = `Resultado: ${data.resultado}`;
    })

    //capturar erros de conexão com o servidor
    .catch(error => {
        console.error('Erro:', error);
    });
}