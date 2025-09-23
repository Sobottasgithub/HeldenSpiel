FMT   = google-java-format
FILES = $(shell find . -name '*.java')

.PHONY: fmt
fmt:
	@echo "Formatting all Java files..."
	@for f in $(FILES); do \
		echo "  $$f"; \
		$(FMT) -i $$f; \
	done
