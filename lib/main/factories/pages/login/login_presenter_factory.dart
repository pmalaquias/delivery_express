import '../../../../presentation/presenter/presenter.dart' show GetxLoginPresenter;
import '../../../../ui/pages/pages.dart' show LoginPresenter;
import '../../factories.dart';

LoginPresenter makeGetxLoginPresenter() => GetxLoginPresenter(
      validation: makeLoginValidation(),
      authentication: makeFirebaseAuthentication(),
    );
