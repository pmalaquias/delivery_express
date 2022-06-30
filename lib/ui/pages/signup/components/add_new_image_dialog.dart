import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;

class AddNewImageDialog extends StatelessWidget {
  const AddNewImageDialog({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text(AppLocalizations.of(context)!.addAPhoto),
      scrollable: true,
      content: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          ElevatedButton.icon(
            icon: const Icon(Icons.insert_photo_rounded),
            onPressed: () {},
            label: Text(AppLocalizations.of(context)!.fromGallery),
          ),
          const SizedBox(height: 16),
          ElevatedButton.icon(
            icon: const Icon(Icons.photo_camera_rounded),
            onPressed: () {},
            label: Text(AppLocalizations.of(context)!.fromCamera),
          ),
        ],
      ),
    );
  }
}
