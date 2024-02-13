import 'package:flutter/material.dart';

import '../../../extension/extension.dart';

class AddNewImageDialog extends StatelessWidget {
  const AddNewImageDialog({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text(context.loc.addAPhoto),
      scrollable: true,
      content: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          ElevatedButton.icon(
            icon: const Icon(Icons.insert_photo_rounded),
            onPressed: () {},
            label: Text(context.loc.fromGallery),
          ),
          const SizedBox(height: 16),
          ElevatedButton.icon(
            icon: const Icon(Icons.photo_camera_rounded),
            onPressed: () {},
            label: Text(context.loc.fromCamera),
          ),
        ],
      ),
    );
  }
}
