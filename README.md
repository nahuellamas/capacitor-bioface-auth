# capacitor-bioface-auth

Plugin for capacitor with faceId and Fingerprint auth services.

## Install

```bash
npm install capacitor-bioface-auth
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`authenticate()`](#authenticate)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### authenticate()

```typescript
authenticate() => Promise<{ authenticated: boolean; }>
```

**Returns:** <code>Promise&lt;{ authenticated: boolean; }&gt;</code>

--------------------

</docgen-api>
