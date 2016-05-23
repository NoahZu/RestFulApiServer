package io.github.noahzu.controller;

import io.github.noahzu.entity.HttpRequest;

public abstract class RequestBaseFilter {
	abstract HttpRequest onFilter(HttpRequest request);
}
