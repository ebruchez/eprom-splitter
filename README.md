### What this is

This is a tiny Scala Native program to split an EPROM file into two binary files.

Use case: split a vintage Apple Macintosh Plus ROM file into LO and HI files ready for programming two separate EPROMS.

### Building

You need Scala sbt.

```bash
> sbt
sbt:eprom-splitter> nativeLink
```

### Usage

```bash
target/scala-3.3.3/eprom-splitter \
  Old_World_Mac_Roms/128KB\ ROMs/1986-03\ -\ 4D1F8172\ -\ MacPlus\ v3.ROM \
  lo.bin \
  hi.bin
```