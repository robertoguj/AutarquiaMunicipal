
var ws = new WebSocket(URL_APLICACAO.replace("http://", "ws://") + "/integracaoViabilidadesWSEndpoint");

ws.onopen = function(evt) {
	console.log("Web Socket esta conectado!!");
};

ws.onmessage = function(evt) {
	var msg = evt.data;

	if (msg == 'INICIO')
		PF('statusViabilidadeDialog').show();
	else if (msg == 'FIM') {
		atualizarViabilidades();
		PF('statusViabilidadeDialog').hide();
	}
};

ws.onclose = function() {
	console.log("Conexao fechada...");
};
