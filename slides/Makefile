REPO := $(shell git config --get remote.origin.url)
GH_PAGES = .gh-pages

all: src/clj/sample_code.clj

watch:
	boot development

production:
	boot production

publish: production
	cp -r resources/public/* $(GH_PAGES)
	cd $(GH_PAGES) && \
		git add . && \
		git commit --message="Publish @$$(date)"
	cd $(GH_PAGES) && \
		git push origin gh-pages

clean:
	rm -rf $(GH_PAGES) resources/public target/stale target/classes src/clj/sample_code.clj

.PHONY: all clean publish watch production

.gh-pages:
	@echo $(REPO)
	git clone "$(REPO)" "$(GH_PAGES)" || echo "$(GH_PAGES) exists"
	@echo "Donezo"
	(cd $(GH_PAGES) && git checkout gh-pages) || (cd $(GH_PAGES) && git checkout --orphan gh-pages && git rm -rf .)

src/clj/sample_code.clj: src/cljs/simplicity_deck/sample_code.cljs.hl
	@echo "(ns sample-code)\n\n" > $@
	awk '/;;{{/ {p=1}; p; /;;}}/ {p=0}' $< >> $@
	perl -pi -e 's/;;({{|}})//;s/^ {3,4}//;' $@

