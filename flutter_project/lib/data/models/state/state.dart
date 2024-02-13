import 'dart:convert';

Estados stateFromMap(String str) => Estados.fromMap(json.decode(str));

String stateToMap(Estados data) => json.encode(data.toMap());

class Estado {
  final String sigla;

  final String nome;
  final List<String> cidades;
  Estado({
    required this.sigla,
    required this.nome,
    required this.cidades,
  });

  factory Estado.fromMap(Map<String, dynamic> json) => Estado(
        sigla: json["sigla"],
        nome: json["nome"],
        cidades: List<String>.from(json["cidades"].map((x) => x)),
      );

  Map<String, dynamic> toMap() => {
        "sigla": sigla,
        "nome": nome,
        "cidades": List<dynamic>.from(cidades.map((x) => x)),
      };

  @override
  String toString() => 'Estado(sigla: $sigla, nome: $nome, cidades: $cidades)';
}

class Estados {
  final List<Estado> estados;

  Estados({
    required this.estados,
  });

  factory Estados.fromMap(Map<String, dynamic> json) => Estados(
        estados: List<Estado>.from(json["estados"].map((x) => Estado.fromMap(x))),
      );

  Map<String, dynamic> toMap() => {
        "estados": List<dynamic>.from(estados.map((x) => x.toMap())),
      };
}
