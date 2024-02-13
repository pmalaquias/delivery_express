import 'package:equatable/equatable.dart';

import '../../../domain/entities/entities.dart' show AccountEntity;
import '../../http/http.dart' show HttpError;

class RemoteAuthResultModel extends Equatable {
  final String accessToken;

  const RemoteAuthResultModel({
    required this.accessToken,
  });

  factory RemoteAuthResultModel.fromJson(Map<String, dynamic> json) {
    if (!json.containsKey('accessToken')) {
      throw HttpError.INVALID_DATA;
    }

    return RemoteAuthResultModel(accessToken: json['accessToken']);
  }

  AccountEntity toEntity() => AccountEntity(token: accessToken);

  @override
  List<Object?> get props => [accessToken];
}
