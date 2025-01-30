import js from '@eslint/js';
import globals from 'globals';
import reactHooks from 'eslint-plugin-react-hooks';
import reactRefresh from 'eslint-plugin-react-refresh';
import tseslint from 'typescript-eslint';
import pluginRouter from '@tanstack/eslint-plugin-router';
import stylistic from '@stylistic/eslint-plugin'

export default tseslint.config(
  { ignores: ['dist'] },
  {
    extends: [js.configs.recommended, ...tseslint.configs.recommended],
    files: ['**/*.{ts,tsx}'],
    languageOptions: {
      ecmaVersion: 2020,
      globals: globals.browser,
    },
    plugins: {
      'react-hooks': reactHooks,
      'react-refresh': reactRefresh,
      '@tanstack/router': pluginRouter,
      '@stylistic': stylistic
    },
    rules: {
      ...reactHooks.configs.recommended.rules,
      'react-refresh/only-export-components': [
        'warn',
        { allowConstantExport: true },
      ],
      '@tanstack/router/create-route-property-order': 'error',
      '@stylistic/indent': ['error', 2],
      '@stylistic/semi': ["error", "always"],
      '@stylistic/comma-dangle': ["error", {
        "arrays": "always",
        "objects": "always",
        "imports": "never",
        "exports": "never",
        "functions": "never",
        "importAttributes": "never",
        "dynamicImports": "never"
      }],
      '@stylistic/quotes': ["error", "single"],
      '@stylistic/jsx-quotes': ["error", "prefer-double"],
      '@stylistic/max-len': ["error", { code: 80, tabWidth: 2 }],
    },
  },
);
