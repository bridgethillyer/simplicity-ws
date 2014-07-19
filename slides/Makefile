REPO := $(shell git config --get remote.origin.url)
GH_PAGES = .gh-pages

watch:
	boot development

production:
	boot production

.gh-pages:
	@echo $(REPO)
	git clone "$(REPO)" "$(GH_PAGES)" || echo "$(GH_PAGES) exists"
	@echo "Donezo"
	(cd $(GH_PAGES) && git checkout gh-pages) || (cd $(GH_PAGES) && git checkout --orphan gh-pages && git rm -rf .)

publish: production
	cp -r resources/public/* $(GH_PAGES)
	cd $(GH_PAGES) && \
		git add . && \
		git commit --message="Publish @$$(date)"
	cd $(GH_PAGES) && \
		git push origin gh-pages

clean:
	rm -rf $(GH_PAGES) resources/public target/stale target/classes

.PHONY: init clean commit watch production
