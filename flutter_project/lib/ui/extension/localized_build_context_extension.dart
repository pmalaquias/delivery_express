import 'package:flutter/material.dart';

import '../../l10n/strings/app_localizations.dart' show AppLocalizations;

extension LocalizedBuildContext on BuildContext {
  AppLocalizations get loc => AppLocalizations.of(this)!;
}
