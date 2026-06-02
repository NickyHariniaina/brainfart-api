package com.ferrissushi.brainfart.file.hash;

import com.ferrissushi.brainfart.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
