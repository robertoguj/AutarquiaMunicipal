function Container() {
};

Container.idDivPDF = 'viewDocumentosGlobal';

Container.CriarElementoPDF = function(srcPDF) {
	if (!Container.detectarAdobeAcrobat()) {
		alert("Você não possui o Adobe Acrobat.");
		return;
	}

	var objetoPDF = document.createElement('Object');
	objetoPDF.data = srcPDF;
	objetoPDF.id = 'objetoPDF';
	objetoPDF.type = "application/pdf";
	objetoPDF.width = '100%';
	objetoPDF.height = '100%';
	document.getElementById(Container.idDivPDF).innerHTML = '';
	document.getElementById(Container.idDivPDF).appendChild(objetoPDF);
};

Container.CriarElementoIframe = function(id, srcIframe) {

	var objetoIframe = document.createElement('iframe');

	objetoIframe.id = id;
	objetoIframe.style.display = "none";
	objetoIframe.src = srcIframe;
	document.getElementById(Container.idDivPDF).innerHTML = '';
	document.getElementById(Container.idDivPDF).appendChild(objetoIframe);
};

Container.SelectAll = function(element) {
	element.focus();
	element.select();
};

Container.ImprimirIframe = function(id, html) {

	var iframe = document.getElementById(id);
	iframe.contentDocument.write('<body onload="window.print()">' + html + '</body>');
	iframe.contentDocument.close();
	return false;
};

Container.detectarAdobeAcrobat = function() {
	return window.navigator.plugins["Adobe Acrobat"];
};

Container.detectarAdobeAcrobat = function() {
	return window.navigator.plugins["Adobe Acrobat"];
};

PrimeFaces.locales['pt_BR'] = {
	closeText : 'Fechar',
	prevText : 'Anterior',
	nextText : 'Próximo',
	currentText : 'Começo',
	monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
	monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
	dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado' ],
	dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb' ],
	dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
	weekHeader : 'Semana',
	firstDay : 1,
	isRTL : false,
	showMonthAfterYear : false,
	yearSuffix : '',
	timeOnlyTitle : 'Só Horas',
	timeText : 'Tempo',
	hourText : 'Hora',
	minuteText : 'Minuto',
	secondText : 'Segundo',
	currentText : 'Data Atual',
	ampm : false,
	month : 'Mês',
	week : 'Semana',
	day : 'Dia',
	allDayText : 'Todo Dia'
};

var statusDlgTimer = null;

function showStatusDialog() {
	if (statusDlgTimer === null) {
		statusDlgTimer = setTimeout(function() {
			PF('statusDialog').show();
		}, 1000);
	}
}

function hideStatusDialog() {
	
	if (statusDlgTimer !== null) {
		clearTimeout(statusDlgTimer);
		PF('statusDialog').hide();
		statusDlgTimer = null;
		$('#countdown').timeTo("reset");
	}
}

function formatar_mascara(e, src, mask) {
	var _TXT = 0;
	if (window.event) {
		_TXT = e.keyCode;
	} else if (e.which) {
		_TXT = e.which;
	}
	if (_TXT > 47 && _TXT < 58) {
		var i = src.value.length;
		var saida = mask.substring(0, 1);
		var texto = mask.substring(i);
		if (texto.substring(0, 1) != saida) {
			src.value += texto.substring(0, 1);
		}
		return true;
	} else if (_TXT == 0) {
		return true;
	} else {
		if (_TXT != 8) {
			return false;
		} else {
			return true;
		}
	}
}

function somenteNumero(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58) || tecla == 0 || tecla == 13)
		return true;
	else {
		if (tecla != 8)
			return false;
		else
			return true;
	}
}

function validarEmail(email) {
	var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	if (email.length > 0 && !(filter.test(email))) {
		return false;
	}
	return true;
}

function formatar_mascara_ddd_celular(e, src) {
	if (e.which == 8 || e.which == 0) // para funcionar backspace e delete no
										// campo
		return true;
	var celular = src.value;
	src.value = formatar_mascara_ddd_9(celular);
}

function formatar_mascara_ddd_telefone(e, src) {
	if (e.which == 8 || e.which == 0) // para funcionar backspace e delete no
										// campo
		return true;
	var telefone = src.value;
	src.value = formatar_mascara_ddd(telefone);
}

function formatar_mascara_ddd(valorTelefone) {
	if (valorTelefone.length == 1) {
		valorTelefone = "(" + valorTelefone;
	} else if (valorTelefone.length == 3) {
		valorTelefone = valorTelefone + ")";
	} else if (valorTelefone.length == 8) {
		valorTelefone = valorTelefone + "-";
	}
	return valorTelefone;
}

function formatar_mascara_ddd_9(valorTelefone) {
	if (valorTelefone.length == 1) {
		valorTelefone = "(" + valorTelefone;
	} else if (valorTelefone.length == 3) {
		valorTelefone = valorTelefone + ")";
	} else if (valorTelefone.length == 9) {
		valorTelefone = valorTelefone + "-";
	}
	return valorTelefone;
}

/* Máscaras ER */
function mascara(o,f){
    v_obj=o;
    v_fun=f;
    setTimeout("execmascara()",1);
}
function execmascara(){
    v_obj.value=v_fun(v_obj.value);
}
function mtel(v){
    v=v.replace(/\D/g,"");             //Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}