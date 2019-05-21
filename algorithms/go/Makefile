PACKAGES=$(shell go list ./... | grep -v /vendor/)
RACE := $(shell test $$(go env GOARCH) != "amd64" || (echo "-race"))
GOBIN_PATH := "$(PWD)/bin"

help:
	@echo 'Available commands:'
	@echo
	@echo 'Usage:'
	@echo '    make deps           Install the project dependencies'
	@echo '    make build          Compile the project.'
	@echo '    make clean          Clean the binaries.'
	@echo

deps: ## install protoc-gen-go and grpc
	# @go get -u <<package_name>>

test: ## run tests, except integration tests
	@go test ${RACE} ${PACKAGES}

build:
	@echo "Compiling..."
	@mkdir -p ./bin
	@GOBIN=${GOBIN_PATH} go install -i ./...
	@echo "All done! The binaries is in ./bin let's have fun!"

clean:
	@echo "Cleaning the binaries"
	@rm -rf bin
	@echo "All done! The binaries were cleaned!"
