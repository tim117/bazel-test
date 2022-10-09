package models

type Error interface {
	Error() *ApiError
}

type ApiError struct {
	Type    ErrorType `json:"type"`
	Message string    `json:"message,omitempty"`
}

func (e ApiError) Error() *ApiError {
	return &e
}

type ErrorType int

const (
	PaginationError ErrorType = iota
	DatabaseError
	BadRequestError
	NotFoundError
)

var errorDescriptions = map[ErrorType]string{
	PaginationError: "Errors that occur while parsing the given pagination.",
	DatabaseError:   "Errors that occur when communicating with the database.",
	BadRequestError: "Errors with the given input.",
	NotFoundError:   "Errors when the resource is not found.",
}

func (e ErrorType) Description() string {
	return errorDescriptions[e]
}
