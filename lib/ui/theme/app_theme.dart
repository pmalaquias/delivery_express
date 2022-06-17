import 'package:flutter/material.dart';

import 'app_colors.dart';
import 'app_text_theme.dart';

mixin AppTheme {
  static const Color _lightFillColor = AppColors.black;
  static const Color _darkFillColor = AppColors.background;

  static final Color _lightFocusColor = _lightFillColor.withOpacity(0.12);
  static final Color _darkFocusColor = _darkFillColor.withOpacity(0.12);

  static ThemeData lightThemeData = themeData(lightColorScheme, _lightFocusColor);
  static ThemeData darkThemeData = themeData(darkColorScheme, _darkFocusColor);

  static ThemeData themeData(final ColorScheme colorScheme, final Color focusColor) => ThemeData(
        canvasColor: colorScheme.background,
        colorScheme: colorScheme,
        disabledColor: colorScheme.onBackground.withAlpha(40),
        dividerColor: colorScheme.onBackground.withAlpha(40),
        elevatedButtonTheme: elevatedButtonThemeData(colorScheme),
        errorColor: colorScheme.error,
        focusColor: focusColor,
        fontFamily: 'Montserrat',
        highlightColor: Colors.transparent,
        iconTheme: IconThemeData(color: colorScheme.onPrimary),
        inputDecorationTheme: inputDecorationTheme(colorScheme),
        primaryColor: colorScheme.primary,
        primaryColorLight: colorScheme.primaryContainer,
        scaffoldBackgroundColor: colorScheme.background,
        textTheme: AppTextTheme.montserratTextTheme,
        toggleableActiveColor: AppColors.primaryRed,
        useMaterial3: true,
      );

  static const ColorScheme lightColorScheme = ColorScheme(
    background: AppColors.background,
    brightness: Brightness.light,
    error: AppColors.danger,
    onBackground: AppColors.black,
    onError: AppColors.background,
    onPrimary: AppColors.background,
    onSecondary: AppColors.background,
    onSurface: AppColors.black,
    primary: AppColors.primaryRed,
    secondary: AppColors.purple,
    surface: AppColors.background,
  );

  static const ColorScheme darkColorScheme = ColorScheme(
    background: AppColors.black,
    brightness: Brightness.dark,
    error: AppColors.danger,
    onBackground: AppColors.background,
    onError: AppColors.black,
    onPrimary: AppColors.black,
    onSecondary: AppColors.black,
    onSurface: AppColors.background,
    primary: AppColors.primaryRed,
    secondary: AppColors.purple,
    surface: AppColors.black,
  );

  static ElevatedButtonThemeData elevatedButtonThemeData(final ColorScheme colorScheme) => ElevatedButtonThemeData(
        style: ElevatedButton.styleFrom(
          elevation: 0,
          onPrimary: colorScheme.onPrimary,
          onSurface: colorScheme.onSurface,
          padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 32),
          primary: colorScheme.primary,
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
          textStyle: AppTextTheme.montserratTextTheme.subtitle1?.copyWith(color: colorScheme.onPrimary),
        ),
      );

  static InputDecorationTheme inputDecorationTheme(final ColorScheme colorScheme) => InputDecorationTheme(
        /* enabledBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.onBackground.withAlpha(80),
          ),
        ), */
        errorBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.error,
          ),
        ),
        /* focusedBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.onBackground.withAlpha(200),
          ),
        ), */
        disabledBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.onBackground.withAlpha(40),
          ),
        ),
        focusedErrorBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.error,
          ),
        ),
        labelStyle: AppTextTheme.montserratTextTheme.bodyText1,
        hintStyle: AppTextTheme.montserratTextTheme.subtitle1?.copyWith(
          color: colorScheme.onBackground.withAlpha(40),
        ),
      );
}
