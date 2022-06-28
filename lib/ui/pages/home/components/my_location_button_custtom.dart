import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;

class MyLocationButtonCusttom extends StatelessWidget {
  final Function() currentLocation;

  const MyLocationButtonCusttom({
    Key? key,
    required this.currentLocation,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Align(
        alignment: Alignment.bottomRight,
        child: FloatingActionButton(
          onPressed: currentLocation,
          child: const Icon(Icons.my_location_rounded),
          tooltip: AppLocalizations.of(context)!.tooltipMyLocation,
        ),
      ),
    );
  }
}
